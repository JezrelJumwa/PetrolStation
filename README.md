# Petrol Station 
* This is an Android application for Inventory Management in a petrol Station for majorly Petroleum.
* The system is fully stable and operable on Android 4.4 and Higher, it is built using old code but 
  fully stable, any feature updates will be uploaded to this repository.
* The system is built on majorly java and relies on sqlite for database management.

# Database Architecture

```java
private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDBStations.db";
    public static final String STATION_TABLE_NAME = "stations";
    public static final String STATION_COLUMN_ID = "id";
    public static final String STATION_COLUMN_NAME = "product";
    public static final String STATION_COLUMN_LOCATION = "station_location";
    public static final String STATION_COLUMN_Date = "date";
    public static final String STATION_COLUMN_Start_Time = "time";
    public static final String STATION_COLUMN_Price = "price";
    public static final String STATION_COLUMN_Quantity = "quantity";
```

* The database name is as shown above and the required tables for the application to function 
 effectively.
* It is created on system start and relies majorly on phone internal storage to be able to function
 efficiently.