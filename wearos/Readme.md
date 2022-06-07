# Wear OS Aufgabe
## Anlegen eines Wear OS Emulators
**1.1** Öffnen Sie den AVD-Manager in Android Studio. Wählen Sie **Wear OS** aus und klicken Sie auf **Create device**. \
**1.2** Wählen Sie **Wear OS Small Round** aus und klicken Sie auf **Next**. \
![Select Hardware](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/AVD_Select_Hardware.png) \
**1.3** Wählen Sie den Release **R** (Android 11.0 (Wear OS 3 - Preview)) aus. Möglicherweise müssen Sie das Image durch einen Klick auf **Download** herunterladen. Klicken Sie anschließend auf **Next**. \
![System Image](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/AVD_System_Image.png) \
**1.4** Beenden Sie den Vorgang durch einen Klick auf **Finish**. Ihnen sollte nun ein lauffähiger Wear OS Emulator für die folgenden Aufgaben zur Verfügung stehen. \
![Finish](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/AVD_Finish.png)

## Erste Schritte mit Compose for Wear OS
In der folgenden Aufgabe soll eine App entwickelt werden, mit der über die Smartwatch protokolliert werden kann, wann und wieviel getrunken wurde. Bisher fehlt der App jedoch noch die Möglichkeit die Trinkmenge festzulegen. Hier kommen Sie ins Spiel.

**2.1** In der ***AddScreen.kt*** muss in der onClick-Methode des ersten Chip's der navController benutzt werden, um zum StepperScreen zu navigieren. Nutzen sie dafür die Route "Stepper".

Tipp: Schauen Sie sich die Vorlesungsfolien zur Navigation an.

**2.2** In der Datei ***StepperScreen.kt*** muss ein Stepper erstellt werden, der als Wert die Variable amount benutzt. Durch einen Increase und eine Decrease Button soll der Wert der Variablen in fünfziger Schritten erhöht oder verringert werden können. Der Wert darf dabei jedoch nie kleiner als 50 und nie größer als 2000 werden. In der Mitte des Steppers soll der aktuelle Wert angezeigt werden. Der fertige Stepper sollte etwa so aussehen: \
![StepperScreen](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Stepper.png)

Tipp: Schauen Sie sich die Vorlesungsfolien zur UI Komponente Stepper an.

**2.3** Testen Sie die fertige App und machen Sie sich mit der Benutzung vertraut.
