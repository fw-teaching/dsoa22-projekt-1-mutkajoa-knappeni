# Projekt 1 - Ruttsökning

### Av Niklas Knappe och Joakim Mutka
Projektet är utvecklat i docker miljön i visual studio code som gavs i projekt-repon.

### Del 1 - Klassen Node
Klassen Node är uppbyggd enligt uppgiftens specs. Klassen har de relevanta variablerna som behövs samt getters och setters för dem. 
Programmet anropar metoden createGraph utan errors.

### Del 2 - Skriv ut namnen på alla biblioteken samt lista grannarna
Vi gjorde en Route.java klass för att ha allting rutt relaterat på samma plats.
Vi returnerar från metoden listNodesAndLinks() en string som är formaterad på likadant sätt som Fredriks.

### Del 3 - Beräkna uppskattad kostnad H (distans) från en nod till given destination
I vår klass Node finns metoden calculateH som tar emot en Node som parameter, och räknar ut den uppskattade distansen till den angivna noden från innevarande nod(this).
För uträkningen av distansen används den färdiga statiska metod som gavs i Utils klassen.
Metoden fungerar enligt projektbeskrivningen och returnerar en double med "H-värdet".

### Del 4 - Beräkna total kostnad G från en given startpunkt till innevarande nod
Så som calculateH finns också metoden calculateG i vår Node klass som tar emot ett Node objekt. 
I Node klassen finns också metoden getF som returnerar ruttens F-värde som en double.

### Del 5 - Implementera A* algoritmen för att beräkna kortaste rutten mellan en given startpunkt och destination
Metoden getRoute är definierad, och tar emot två Node objekt som parametrar, implementerar A* algoritmen enligt angiven pseudokod, och returnerar en ArrayList med Node objekt
med alla noder som skall besökas för att få kortaste rutten. 
Några buggar hade vi att reda ut, vilket också resulterade den försenade inlämningen.

### Del 6 - Stil och logik
Vi har följt javas naming conventions.
OOP används, inga onödiga upprepningar av kod och det finns print statements endas i Main.java.
Kommentarer finns det inte många av för att koden är ganska självklar.
Felhantering genom while loopar och if satser.