# Conditions
[Contact data source format](#contact-data-source-format-xml)

[Contact data target format](#contact-data-target-format-tabular)

## Contact data source format (XML)
The application should be able to read and parse data of the following format:

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<Contacts>
  <contact id="1">
    <firstname>Max</firstname>
    <lastname>Mustermann</lastname>
    <birthdate>01.01.1970</birthdate>
    <street>Musterstrasse</street>
    <number>1</number>
    <zipcode>12345</zipcode>
    <city>Musterhausen</city>
    <country>Germany</country>
  </contact>
  <contact id="2">
    <firstname>John</firstname>
    <lastname>Doe</lastname>
    <birthdate>11.11.2000</birthdate>
    <street>Mainstreet</street>
    <number>1</number>
    <zipcode>ST 7UR</zipcode>
    <city>London</city>
    <country>United Kingdom</country>
  </contact>  
</Contacts>
```

## Contact data target format (tabular)
```
firstname;lastname;birthdate;street;number;zipcode;city;country
Max;Mustermann;01.01.1970;Musterstrasse;12345;Musterhausen;Germany
John;Doe;11.11.2000;Mainstreet;1;ST 7UR;London;United Kingdom
```
