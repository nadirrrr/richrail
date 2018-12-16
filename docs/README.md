# Docs of the application
Dit project is gemaakt door Nadir en Berkay.
Negeer de Controller in de klassediagram. Deze is er perongeluk bijgevoegd. Correcte versie zonder de Controller klasse wordt zsm geupload.

# Beschrijving klassendiagram
In het klassendiagram zijn de relaties en de kardinaliteit tussen klassen en interfaces te zien. Een trein bevat één of meerdere locomotieven of wagons. Een locomotief en een wagon zit vast aan altijd één trein. Locomotief en wagon implementeert de interface RollingComponent. Doordat er gebruik wordt gemaakt van een interface, zouden er in de toekomst met gemak overige RollingComponents toegevoegd kunnen worden.
 
FileStorage implementeert de interface Storage. In de controller bevindt zich de brug tussen het domein model en de GUI (view). De controller bevat namelijk de business logica voor de GUI. Aan de hand van JavaFX FXML houden we de GUI geschriden vvan de business logica. Dit is echter geen MVC pattern.
 
Aanvullende informatie wordt toegelicht tijdens de presentatie op dinsdag.
