#Jak pracuje algoritmus.

# Algoritmus #

Je použit algoritmus prohledávání stavového prostoru (A`*`).
## Popis A`*` ##
  1. Počáteční stav se vloží do paměti OPEN.
  1. Je-li OPEN prázdný, řešení neexistuje (konec prohledávaní).
  1. Z paměti OPEN se vybere hodnota s nejmenší hodnotou f(). Pokud je těchto stavů více zvolte jeden náhodně.
  1. Vybraný stav odstraní z paměti OPEN a vloží do paměti CLOSE.
  1. Jeli vybraný stav cílový, je nalezeno řešení (konec prohledávání).
  1. Expanduje se vybraný stav (vygenerují se všechny možné následující stavy). Vygenerované hodnoty se vloží do paměti OPEN (zamezuje se duplicitě a zvýhodňují se prvky s lepší hodnotou f()).
  1. Přejít na krok 2.

# Příklad #

Funkčnost algoritmu budu prezentovat na ukázkovém příkladu. Pokud zde budu používat souřadnice, počátek souřadnic je v levém horním rohu.

---

Výchozí stav:<br>
<img src='http://img507.imageshack.us/img507/2420/vchozstav.png' />
<br>
Cílový stav:<br>
<img src='http://img834.imageshack.us/img834/6131/vchozstav1.png' /><br>
Řešení:<br>
<ul><li>Zhasnout žárovku na souřadnicích 0,0.<br>
</li><li>Zhasnout žárovku na souřadnicích 1,1.<br>
</li><li>Zhasnout žárovku na souřadnicích 2,2.</li></ul>

<h2>Pravidla</h2>

Seznam pravidel, které jsou použity v algoritmu. (Souřadnice [x,y] označují žárovku na kterou se má kliknout).<br>
<ul><li>Stejné souřadnice se v jedné větvi používají pouze jednou.<br>
</li><li>Klikni na svíticí žárovku se souřadnicemi [x,y].<br>
</li><li>Klikni pod svíticí žárovku se souřadnicemi [x,y].<br>
</li><li>Klikni nad svíticí žárovku se souřadnicemi [x,y].<br>
</li><li>Klikni vpravo svíticí žárovku se souřadnicemi [x,y].<br>
</li><li>Klikni vlevo svíticí žárovku se souřadnicemi [x,y].</li></ul>

<h2>Výpočet hodnoty h()</h2>
Hodnota h() se vypočítá následujícím postupem:<br>
<ul><li>Po hrací ploše se posouvá maska. Do masky se započítávají pouze ty pole které nejsou mimo hrací plochu.<br>
<img src='http://img534.imageshack.us/img534/8813/vchozstav2.png' />
</li><li>Střed masky se posouvá po hracím poli. Dokud nevystřídá všechny pole hracího pole.<br>
</li><li>Pokud jsou v masce všechny žárovky rozsvíceny, tak se všechny zhasnou.<br>
<img src='http://img141.imageshack.us/img141/8485/vchozstav3.png' />
<img src='http://img545.imageshack.us/img545/6944/vchozstav4.png' />
</li><li>Když se posune maska až na konec spočítají se zbylé rozsvícené žárovky. Tak dostaneme hodnotu h().