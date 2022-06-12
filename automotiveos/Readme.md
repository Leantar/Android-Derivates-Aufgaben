# Automotive OS Aufgabe
## Einrichtung 
**1.1** Öffnen Sie das MATE Terminal und führen Sie folgendes Kommando aus um Android Studio zu öffnen
```bash
bash ~/Desktop/android-studio/bin/studio.sh
```
**1.2** Sollte sich das Projekt nicht automatisch öffnen, dann ist dies unter ~/Desktop/Automotive zu finden.

## Emulator Einführung

**2.1** Wählen Sie das Gerät "Polestar 2 API 29" aus und starten sie wie gewohnt ihre App über Android Studio.

**2.2** Wenn der Emulator hochgefahren ist, starten Sie die erstellte App, indem Sie zuerst in der oberen Navigationszeile
auf das Fenster klicken (zweites Symbol von rechts) und anschließend ihre App auswählen.
![Polestar](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Polestar_Screen.png)
**2.3** Mit dem Polestar 2 Emulator lassen sich die Sensordaten im Menü "Extendend Controls" unter dem Menüpunkt
"Car data" beeinflussen (Siehe Bilder). Weitere Sensoren sind unter dem Menüpunkt "Virtual sensors" zu finden, welche jedoch für diese Laboraufgabe 
unrelevant sind.
![ExtendedControls](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Extended_Controls.png)
![CarData](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Car_Data.png)

## Laboraufgabe Automotive OS

**3.1** Starten Sie die App und korrigieren Sie den Fehler.

**3.2** Die App ist von UX-Beschränkungen betroffen, heben Sie diese Beschränkungen auf. 
INFO: Leider lässt sich dies nicht verifizieren. Schauen Sie hierfür in den Vorlesungsfolien unter Fahrerablenkung nach.

**2.3** Erweitern Sie die App um einen zusätzlichen Screen, welcher die Modellinformationen des Fahrzeuges anzeigt. 
Dabei sollte der Hersteller, der Modellname und das Baujahr in unterschiedlichen Reihen auf dem Screen angezeigt werden. 
TIPP: Das Objekt, welches die Modellinformationen enthält, ist unter androidx.car.app.hardware.info.Model zu finden.
Verwenden Sie die Methode androidx.car.app.hardware.info.CarInfo.fetchModel, um das Model Objekt von der API zu erhalten.
