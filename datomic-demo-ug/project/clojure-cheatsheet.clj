;komentarz
(+ 1 2 3)
(< 1 2 3 4 5)

(def people ["Adam", "Ewa", "Piotr", "Danuta"])
(map count people)
(map (fn [o] (str o "!")) people)

(def movie (ref "Die hard"))
@movie

;wazne! dosync i zastosowanie metod 
(dosync (alter movie str " 2"))