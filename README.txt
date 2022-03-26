Tema1 POO CB: 
Coadă Vlad 322 CB


Pentru tema am folosit algoritmul Dijkstra.
Initial am declarat 2 clase: Edge si Vertex.
	In clasa Vertex am declarat o variabila decizionala pentru a sti daca un nod a fost 
sau nu vizitat, un nume pentru acest nod, o lista cu noduri, un nod predecesor(pr). Printre metode se regasesc getteri, setteri, 
constructori (pentru un nod(vertex)), rescrierea toString pentru numele nodului, si o metoda de comparare a 2 noduri (rescrierea 
metodei compareTo). 
	In clasa dedicata pentru strada (Edge), am declarat lungimea strazii, nodul de inceput, nodul de sfarsit, gabaritul admisibil 
pe strada, ambuteiajul. Pentru toate acestea iarasi setteri, getteri si un constructor pentru edge cu parametri.
	Pentru aflarea drumului am recurs la crearea unei clase PathFinder, in care am imlimentat metoda propriu-zisa, ShortestP. 
La extragerea din lista, nu avem nevoie de noduri in formatul P, de aceea aceasta litera e inlocuita cu spatiu gol.
Metoda getShortestP returneaza path ca un string.
	Ultima clasa e clasa de baza Dijkstra, in care am declarat 2 liste pentru strazi si gabarite.Tot aici se afla metoda main 
si cele 3 metode strict necesare addRestriction, addStreet si drive.
 