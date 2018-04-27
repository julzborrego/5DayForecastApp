This app uses a MVVM architectual pattern.
The data in Forecast Activity xml is bound to the Forecast ViewModel. It observes it and updates the UI when the viewmodel changes(the API call is made in this case).
The observable uses Live data to do this.
This app implements design patterns observers and singletons(WeatherAPI, and Volley obj)

Instructions:
This app was written in java using the Android Studio IDE
Please clone the repository using git and open and run in Android studio

Things that could be improved if given more time:
More UI and unit testing
More clear and thourough Documentation
I designed this to the given specs but their could be and option to enter in the zip or city, or use the location manager to find the users location.

Screenshots: ![image](https://imgur.com/a/hz7F499)