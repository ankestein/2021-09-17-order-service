# Freitagsaufgabe - Problemstellung
Der Auftraggeber wünscht sich einen Shop-Service, um seine Produkt-Bestellungen verwalten zu können.
Er möchte auf der Konsole ausgeben lassen können:

- ein einzelnes Produkt
- alle Produkte

Zusätzlich kann er eine neue Bestellung aufgeben. Für jede neue Bestellung möchte er die entsprechenden Produkt-Ids mitangeben.   
Weiterhin möchte er:

- sich eine einzelne Bestellung anhand ihrer id ausgeben lassen.
- alle Bestellungen ausgeben lassen können.

Dafür gibt er euch den ganzen Freitag Zeit.

# Freitagsaufgabe - Tips zum Vorgehen
Implementiere das Bestellsystem **(natürlich mit Tests!)**.

1. Erstelle eine Klasse `ProductRepo`, die eine `Product` Liste enthält.

2. Erstelle eine Klasse `OrderRepo`, die eine `Order` Liste enthält

3. Erstelle eine Klasse `ShopService`, über die wir eine neue `Order` aufgeben können.

4. `throw` eine Exception, wenn Produkte bestellt werden die nicht existieren.

5. 🏋BONUS: Nutze für die `get` Methoden als Rückgabewert ein `Optional`

6. 🏋BONUS: Nutze anstelle einer `Product` Klasse ein Interface und implementiere verschiedene Ausführungen

7. 🏋BONUS: Schaue dir `hamcrest` an und nutze die hamcrest matchers in deinen Tests


![order-system diagram](images/order-system.png)