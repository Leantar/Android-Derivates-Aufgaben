# Automotive OS Aufgabe
## Einrichtung ohne VM (Android Studio Version > 4.2 erforderlich) 
**1.1.1** Navigieren Sie in Android Studio auf den SDK Manager: Tools > SDK Manager  <br />
**1.1.2** Wählen Sie den Tab "SDK Update Sites" aus und klicken Sie auf das "+"-Symbol  <br />
**1.1.3** Geben Sie im neu geöffnetem Fenster als Name "Polestar 2 Sys Image" ein und als
URL https://developer.polestar.com/sdk/polestar2-sys-img.xml  <br />

![SysImg](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/sysimg.PNG)

**1.1.4** Wechseln Sie nun zum Tab "SDK Platforms" und setzen Sie unten rechts einen Haken bei "Show Package Details".  <br />
**1.1.5** Setzen Sie unter Android 10.0 (Q) bei Polestar 2 einen Haken und drücken Sie anschließend zwei Mal auf "OK".  <br />

![SDKManager](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/manager.PNG)

**1.1.6** Akzeptieren Sie die Lizensen und warten Sie bis das Image geladen ist.  <br />
**1.1.7** Starten Sie Android Studio neu und Kreieren Sie nun ein neues Gerät im Device Manager. <br />
**1.1.8** Wählen Sie hierbei als Kategorie "Automotive" und als Gerät "Polestar 2" aus. Drücken Sie nun auf "Next". <br />

![SysImgage](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/EmulatorScreen.PNG)

**1.1.9** Wechseln Sie zum Tab "x86 Images", wählen Sie als System Image "Q" mit dem API Level 29 aus und drücken sie wieder auf "Next". <br />

![SysImgage](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/SysImageAVD.PNG)

**1.1.10** Schließen Sie nun den Prozess mit den vorhandenen Einstellungen ab. <br />


## VM Einrichtung 
**1.2.1** Öffnen Sie das MATE Terminal und führen Sie folgendes Kommando aus um Android Studio zu öffnen
```bash
bash ~/Desktop/android-studio/bin/studio.sh
```
**1.2.2** Sollte sich das Projekt nicht automatisch öffnen, dann ist dies unter ~/Desktop/Automotive zu finden.

## Emulator Einführung

**2.1** Wählen Sie das Gerät "Polestar 2 API 29" aus und starten sie wie gewohnt ihre App über Android Studio.

**2.2** Wenn der Emulator hochgefahren ist, starten Sie die erstellte App, indem Sie zuerst in der oberen Navigationszeile
auf das Fenster klicken (zweites Symbol von rechts) und anschließend ihre App auswählen.
![Polestar](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Polestar_Screen.png)
<br />
**2.3** Mit dem Polestar 2 Emulator lassen sich die Sensordaten im Menü "Extendend Controls" unter dem Menüpunkt
"Car data" beeinflussen (Siehe Bilder). Weitere Sensoren sind unter dem Menüpunkt "Virtual sensors" zu finden, welche jedoch für diese Laboraufgabe 
unrelevant sind.
<br />
![ExtendedControls](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Extended_Controls.png)
![CarData](https://raw.githubusercontent.com/Leantar/Android-Derivates-Aufgaben/main/img/Car_Data.png)


## Laboraufgabe Automotive OS

APP INFO: Permissions werden nur beim Tippen auf dem Grant Permissions Menüpunkt abgefragt und erlaubt. 

**3.1** Starten Sie die App und tippen Sie anschließend auf den Menüpunkt Show Current Speed. In der Konsole ist eine Fehlermeldung zu sehen,
korrigieren Sie den Fehler. Verändern Sie nach der Korrigierung des Fehlers die Geschwindigkeit und lassen Sie sich diese in der App anzeigen.


**3.2** Legen Sie den Gang "D" (Drive) ein. Was ist passiert? 
Heben Sie die Beschränkungen auf. <br />
INFO: Leider lässt sich die Aufgabe mit dem Polestar2 Emulator nicht verifizieren. <br />
TIPP: Schauen Sie, wenn notwendig, in den Vorlesungsfolien unter Fahrerablenkung nach.

**3.3** Erweitern Sie die App um einen zusätzlichen Screen, welcher die Modellinformationen des Fahrzeuges anzeigt. 
Dabei sollte der Hersteller, der Modellname und das Baujahr in unterschiedlichen Reihen auf dem Screen angezeigt werden. 

TIPPS: Kopieren Sie den SpeedScreen und passen Sie die Kopie an. Anschließend muss der Screen im MainScreen zum ScreenManager hinzugefügt werden.
Das Objekt, welches die Modellinformationen enthält, ist unter androidx.car.app.hardware.info.Model zu finden.
Verwenden Sie die Methode androidx.car.app.hardware.info.CarInfo.fetchModel, um das Model Objekt von der API zu erhalten.
