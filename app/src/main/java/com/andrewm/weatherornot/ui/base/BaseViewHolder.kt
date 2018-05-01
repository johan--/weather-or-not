package com.andrewm.weatherornot.ui.base

import android.content.Context
import android.content.ContextWrapper
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.andrewm.weatherornot.BR
import com.andrewm.weatherornot.injection.components.DaggerViewHolderComponent
import com.andrewm.weatherornot.injection.components.ViewHolderComponent
import javax.inject.Inject

/* Base class for ViewHolders when using a view model in an Activity with data binding.
 * This class provides the binding and the view model to the subclass. The
 * view model is injected and the binding is created when the content view is bound.
 * Each subclass therefore has to call the following code in the constructor:
 *    bindContentView(view)
 *
 * After calling this method, the binding and the view model is initialized.
 * saveInstanceState() and restoreInstanceState() are not called/used for ViewHolder
 * view models.
 *
 * Your subclass must implement the MvvmView implementation that you use in your
 * view model. */
abstract class BaseViewHolder<B : ViewDataBinding, VM : MvvmViewModel<*>>(itemView: View) : RecyclerView.ViewHolder(itemView), MvvmView {

    protected lateinit var binding: B
    @Inject
    lateinit var viewModel: VM
        protected set

    protected val viewHolderComponent: ViewHolderComponent by lazy {
        DaggerViewHolderComponent.builder()
                .activityComponent(itemView.context.castWithUnwrap<BaseActivity<*, *>>()?.activityComponent)
                .build()
    }

    protected fun bindContentView(view: View) {
        try {
            ViewHolderComponent::class.java.getDeclaredMethod("inject", this::class.java).invoke(viewHolderComponent, this)
        } catch(e: NoSuchMethodException) {
            //throw RtfmException("You forgot to add \"fun inject(viewHolder: ${this::class.java.simpleName})\" in ActivityViewHolderComponent")
        }

        binding = DataBindingUtil.bind(view)
        binding.setVariable(BR.vm, viewModel)
        viewModel.attachViewOrThrowRuntimeException(this, null)
    }

    fun executePendingBindings() {
        binding.executePendingBindings()
    }

    fun <V : MvvmView> MvvmViewModel<V>.attachViewOrThrowRuntimeException(view: MvvmView, savedInstanceState: Bundle?) {
        try {
            @Suppress("UNCHECKED_CAST")
            this.attachView(view as V, savedInstanceState)
        } catch (e: ClassCastException) {
//            if (this !is NoOpViewModel<*>) {
//                throw RuntimeException(javaClass.simpleName + " must implement MvvmView subclass as declared in " + this.javaClass.simpleName)
//            }
        }
    }


    private inline fun <reified T> Context.castWithUnwrap(): T? {
        if (this is T) return this

        var context = this
        while (context is ContextWrapper) {
            context = context.baseContext
            if (context is T) {
                return context
            }
        }
        return null
    }

}
