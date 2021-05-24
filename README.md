# My Art

<!-- PROJECT LOGO -->
<br />

  <h3 align="center">My Art User Base</h3>

  <p align="center">
    Verwaltung von Userdaten mit Vaadin
    <br />
    <a href="https://github.com/2Alexa/myart_vaadin_java_"><strong>Erkunde die Dokumentation»</strong></a>
    <br />
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Inhaltsverzeichnis</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">&Uumlber das Projekt</a>
      <ul>
        <li><a href="#built-with">Aufbau</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Installation</a>
      <ul>
        <li><a href="#installation">Lass uns es starten</a></li>
      </ul>
    </li>
    <li><a href="#contact">Kontakt</a></li>
    <li><a href="#acknowledgements">Referenzen</a></li>
  </ol>
</details>



## Über das Projekt


In diesem Projekt werde ich mit Hilfe von Vaadin ein Frontend aufbauen. Dabei werde ich die Daten einlesen. 
Es besteht auch die Möglichkeit Datenbank Verbindung zu erstellen.
Auf der User View Seite werden die Userdaten, wie Vorname, Nachname, Status, Email und Gefühl horizontal angezeigt.
Das Gefühl wird als Enum an den User geheftet. 3 Enum haben wir zu Verfügung.
Gleichzeitig können wir die Userdaten abrufen, löschen und filtern.


### Aufbau des Codes


#### Entity anlegen:
Definieren das Datenmodell:
Stellen eine CRM-System da, um eine Verbindung mit den User und dem Gefühl zu erstellen. Erstelle 3 Entity Klassen: User, Gefühl und AbstractEntity.


#### Repository erstellen:
Um auf die Datenbank zuzugreifen, erstellen wir eine Schnittstelle, die den Entitätstyp und Primärschlüssel beschreibt. Hier erstellen wir 2 Klassen, für User und Gefühl.


#### Services Klasse erstellen:
Das UI greift nicht direkt auf die Datenbank, sondern über die Service Klassen auf die Daten. Hier erstellen wir 2 Klassen, für User und Gefühl.

#### Datenbank:
In dem Code Beispiel hab ich die Daten des Users in die Klasse UserService eingefügt. Status wird über den Entity Klasse: Status in der Klasse User definiert.


#### Grid bauen:
Über die MainView  Klasse bauen wir unsere Oberfläche auf. Lese dazu einzelne Kommentare in dem Code. In dem Frontend Package findes du einfachen CSS Code, die Beschreibung dazu findest du auch in dem Kommentaren in den Code der MainView.

### Daten filtern:
Hierbei muss du eine TextField in dem MainView unter den Grid setzen. Die confiqureFilter Methode definiere , dass das Feld textFeld geleert werden soll, nach Wunsch, Daten in Liste zu suchen und User zur Nutzung anweisen.


### Installation:


* []() instaliere Java JDK 8 ( suche auf Google java.com)
* []() instaliere Intellij IDEA CE runter (benutzen Google um die offizielle Seite für den Intellij Download)
* []() H2 Datenbase muss du nicht downloaden, wir benutzen den Browser, um die Daten in der H2 Datenbank zu checken
       http://localhost:8080
* []() instaliere Chrome (Browser, Download über anderen Browser) Wir werden die User Daten über Rested einfügen.
       (Befolge bei Chrome,Einstellungen, Entwicklertool, Rested... oder diesen Link: 
       chrome-extension 
       https://eelcnbccaccipfolokglfhhmapdchbfg/dist/index.html
* []() instaliere MYSQL Workbench (über Google den Download)
 


<!-- GETTING STARTED -->
## Lass uns es starten

Das Projekt wird automatisch von start.spring.io generiert: https://start.vaadin.com/.


Ich verweisen in application.properties, dass ich h2 Datenbank nutzen. Dort kann ich auch auf mySQL gehen(momentan ausmarkiert) auch username und password für die Datenbank anlegen. Der User und Password sind gesetzt.


### Lass uns ausprobieren
Starte die Applikation und geh über den http://localhost:8080


<!-- CONTACT -->
## Contact


Project Link: [https://github.com/2Alexa/myart_vaadin_java_](https://github.com/2Alexa/myart_vaadin_java_)



<!-- ACKNOWLEDGEMENTS -->
## Referenzen

* []() https://vaadin.com/docs/v14/flow/tutorials/in-depth-course
* []() https://dzone.com/articles/how-to-connect-a-mysql-database-to-a-vaadin-applic
* []() https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
* []() https://www.jetbrains.com/help/idea/connecting-to-a-database.html




