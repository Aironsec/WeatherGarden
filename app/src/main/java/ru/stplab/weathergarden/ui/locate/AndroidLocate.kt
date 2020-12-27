package ru.stplab.weathergarden.ui.locate

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Criteria
import android.location.Geocoder
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.stplab.weathergarden.mvp.modal.locate.ILocate
import java.util.*

class AndroidLocate(context: Context) : ILocate {
    private val address: Address? = null
    private val locateSubject = BehaviorSubject.createDefault(listOf(address))

    init {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria().apply { accuracy = Criteria.ACCURACY_COARSE }
        val provider = locationManager.getBestProvider(criteria, true)
        provider?.let {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) return@let

            locationManager.getLastKnownLocation(it)?.let { location ->
                val geocode = Geocoder(context, Locale.getDefault())
                val addresses = geocode.getFromLocation(location.latitude, location.longitude, 1)
                locateSubject.onNext(addresses)
            }
        }
    }

    override fun getLocate(): Single<List<Address?>> = locateSubject.first(listOf(address))
}