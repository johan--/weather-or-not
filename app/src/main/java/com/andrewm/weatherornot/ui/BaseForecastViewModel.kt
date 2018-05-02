package com.andrewm.weatherornot.ui

import android.content.Context
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.ui.base.MvvmView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel

/**
 * Abstract implementation of BaseViewModel and IForecastViewModel.
 * BaseForecastViewModel should be responsible for any common things that all forecast-centric
 * viewModels need to do.
 */
abstract class BaseForecastViewModel<V : MvvmView>(@AppContext context: Context, protected val forecastRepo: ForecastRepo) : BaseViewModel<V>(), IForecastViewModel<V> {

    protected val ctx: Context = context.applicationContext

    override lateinit var forecast: Forecast
        protected set

//    override fun onBookmarkClick() {
//        val realmCountry = countryRepo.getByField("alpha2Code", country.alpha2Code, false)
//
//        if (realmCountry == null) {
//            countryRepo.save(country)
//        } else {
//            country = countryRepo.detach(realmCountry)
//            countryRepo.delete(realmCountry)
//        }
//
//        notifyPropertyChanged(BR.bookmarkDrawable)
//    }

    override fun update(forecast: Forecast) {
        this.forecast = forecast

        notifyChange()
    }

//    override val name: String
//        get() {
//            var nameInfo = country.name + " (" + country.alpha2Code
//            if (country.name != country.nativeName) {
//                nameInfo += ", " + country.nativeName
//            }
//            return nameInfo + ")"
//        }
//
//    override val region: CharSequence
//        get() = SpannableStringBuilder(ctx.getText(R.string.country_region))
//                .append(country.region)
//
//    override val isCapitalVisible: Boolean
//        get() = !TextUtils.isEmpty(country.capital)
//
//    override val capital: CharSequence
//        get() = SpannableStringBuilder(ctx.getText(R.string.country_capital))
//                .append(country.capital)
//
//    override val population: CharSequence
//        get() = SpannableStringBuilder(ctx.getText(R.string.country_population))
//                .append(DECIMAL_FORMAT.format(country.population))
//
//    override val isLocationVisible: Boolean
//        get() = country.lat != null && country.lng != null
//
//    override val location: CharSequence
//        get() {
//            if (isLocationVisible) {
//                return SpannableStringBuilder(ctx.getText(R.string.country_location))
//                        .append(DECIMAL_FORMAT.format(country.lat))
//                        .append(", ")
//                        .append(DECIMAL_FORMAT.format(country.lng))
//            } else {
//                return ""
//            }
//        }
//
//    override val bookmarkDrawable: Drawable
//        @Bindable
//        get() = AppCompatDrawableManager.get().getDrawable(ctx, if (countryRepo.getByField("alpha2Code", country.alpha2Code!!, false) != null) R.drawable.ic_bookmark_black else R.drawable.ic_bookmark_border_black)
//
//    override val isMapVisible: Boolean
//        get() = mapsAvailable && country.lat != null && country.lng != null
//
//    override val cardBottomMargin: Int
//        get() = if (isLast) ctx.resources.getDimension(R.dimen.card_outer_padding).toInt() else 0
}