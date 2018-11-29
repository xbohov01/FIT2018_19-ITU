package team7.itu2018;

public class Test_database {

   public Test_database(){
       Questions[] quest = new Questions[30];
       quest[0] = new Questions("Dať prednosť v jazde sa rozumie",
               "povinnosť účastníka cestnej premávky počínať si tak, aby ten, kto má prednosť v jazde, nemusel náhle zmeniť smer alebo rýchlosť jazdy",
               "povinnosť účastníka cestnej premávky počínať si tak, aby ten, kto má prednosť v jazde, nemusel zmeniť smer jazdy, môže však zmeniť rýchlosť jazdy,",
               "povinnosť účastníka cestnej premávky počínať si tak, aby ten, kto má prednosť v jazde, nemusel zmeniť rýchlosť jazdy, môže však zmeniť smer jazdy.",
               1);

       quest[1] = new Questions("Motorové vozidlo musí mať počas jazdy rozsvietené",
               "svetlá vo vnútri vozidla,",
               "diaľkové svetlomety,",
               "stretávacie svetlomety alebo im na roveň postavené osvetlenie.",
               3);

       quest[2] = new Questions("Vodič",
               "môže počas vedenia vozidla telefonovať alebo inak používať telefónny prístroj,",
               "nesmie počas vedenia vozidla telefonovať alebo inak používať telefónny prístroj okrem telefonovania s použitím systému voľné ruky,",
               "nesmie počas vedenia vozidla počúvať rádio",
               2);

       quest[3] = new Questions("Ak jazdné pruhy nie sú na vozovke vyznačené, jazdným pruhom sa rozumie časť vozovky dovoľujúca jazdu vozidiel",
               "s troma a viacerými kolesami v jazdnom prúde za sebou,",
               "najmenej s dvoma kolesami v jazdnom prúde za sebou,",
               "len s dvoma kolesami v jazdnom prúde za sebou.",
               1);

       quest[4] = new Questions("Vodič predchádzaného vozidla nesmie",
               "okrem zvyšovania rýchlosti jazdy nijako brániť predchádzaniu,",
               "zvyšovať rýchlosť jazdy ani inak brániť predchádzaniu,",
               "znižovať rýchlosť jazdy.",
               2);

       quest[5] = new Questions("Vodič smie jazdiť len primeranou rýchlosťou, aby bol schopný zastaviť vozidlo na vzdialenosť",
               "20 m, na diaľnici a na rýchlostnej ceste 50 m,",
               "30 m",
               "na ktorú má rozhľad.",
               3);

       quest[6] = new Questions("Vodič odbočujúci vľavo je povinný dať prednosť v jazde",
               "len protiidúcim vozidlám,",
               "protiidúcim motorovým vozidlám i nemotorovým vozidlám a električkám idúcim v oboch smeroch a chodcom prechádzajúcim cez vozovku,",
               "len protiidúcim motorovým vozidlám.",
               2);

       quest[7] = new Questions("Ak vodič, ktorý chce zastaviť alebo stáť, zachádza na okraj cesty alebo chodníka",
               "nie je povinný dávať znamenie o zmene smeru jazdy,",
               "je povinný dávať znamenie o zmene smeru jazdy,",
               "je povinný dávať znamenie o zmene smeru jazdy len v obci.",
               2);

       quest[8] = new Questions("Účastník dopravnej nehody",
               "nesmie urobiť žiadne opatrenia na záchranu osoby, ak by to bolo na ujmu vyšetrenia dopravnej nehody,",
               "je povinný umožniť obnovenie cestnej premávky len vtedy, ak dopravnú nehodu zavinil",
               "je povinný urobiť potrebné opatrenia na záchranu osoby alebo majetku ohrozeného dopravnou nehodou.",
               3);

       quest[9] = new Questions("Prerušované žlté svetlo použité samostatne alebo v spojení s dopravnou značkou",
               "znamená povinnosť zastaviť vozidlo pred priechodom pre cyklistov,",
               "znamená povinnosť dať prednosť chodcom na priechode pre chodcov,",
               "upozorňuje na nevyhnutnosť dbať na zvýšenú opatrnosť.",
               3);

       quest[10] = new Questions("Úprava cestnej premávky vykonaná dopravnými značkami a dopravnými zariadeniami",
               "je nadradená všeobecnej úprave cestnej premávky,",
               "je nadradená všeobecnej úprave cestnej premávky len v obytnej zóne, pešej zóne a školskej zóne,",
               "nie je nadradená všeobecnej úprave cestnej premávky.",
               1);

       quest[11] = new Questions("Ak sa vodič motorového vozidla, ktoré je povinne vybavené bezpečnostným odevom, zdržiava na vozovke mimo vozidla počas núdzového státia, najmä pri prerušení jazdy pre chybu na vozidle alebo v dôsledku dopravnej nehody, je povinný",
               "umiestniť 20 m za vozidlo biele neoslňujúce svetlo bielej farby,",
               "bezodkladne privolať odťahovú službu,",
               "mať bezpečnostný odev oblečený.",
               3);

       quest[12] = new Questions("Na bicykli sa jazdí predovšetkým",
               "po chodníku,",
               "po cestičke pre cyklistov,",
               "po ľavej krajnici.",
               2);

       quest[13] = new Questions("Vozidlo sa považuje za technicky nespôsobilé na premávku na pozemných komunikáciách, ak",
               "sú na tej istej náprave použité rôzne pneumatiky,",
               "najnižší bod činnej svietiacej plochy obrysových svetiel je vyššie ako 350 mm nad rovinou vozovky,",
               "diaľkové svetlomety nie je možné prepnúť na obrysové svietidlá.",
               1);

       quest[14] = new Questions(" Hĺbka hlavných drážok v stredovej časti povrchu dezénu pneumatiky, ktorý pokrýva približne tri štvrtiny šírky povrchu dezénu jazdnej plochy pneumatiky, nesmie byť menej ako",
               "u vozidla kategórie L1e 1,5 mm,",
               "u všetkých kategórií vozidiel 1,6 mm,",
               "u vozidla kategórie L1e 1,0 mm.",
               3);

       quest[15] = new Questions("Táto dopravná značka upozorňuje na",
               "železničné priecestie bez závor,",
               "kríženie cesty s električkovou koľajou,",
               "križovatku, kde nie je prednosť v jazde upravená značkami.",
               3);

       quest[16] = new Questions("Táto dopravná značka zakazuje",
               "vjazd motorovým aj nemotorovým vozidlám,",
               "vjazd vozidlám vyznačených druhov,",
               "predchádzanie vozidiel vyznačených druhov.",
               2);

       quest[17] = new Questions("Táto dopravná značka",
               "informuje o smere a vzdialenosti v kilometroch k vyznačenému cieľu (obci),",
               "prikazuje odbočiť vľavo,",
               "vyznačuje cestu s jednosmernou premávkou.",
               1);

       quest[18] = new Questions("Táto dopravná značka znamená:",
               "Smerová tabuľa pre cyklistov (s jedným cieľom),",
               "Smerová tabuľa ku kultúrnemu alebo turistickému cieľu,",
               "Smerová tabuľa k miestnemu cieľu.",
               2);

       quest[19] = new Questions("Táto dopravná značka",
               "informuje o názve rieky, pohoria, prírodnej rezervácie, kultúrnej a historickej pamiatky, časti obce, územia a podobne,",
               "je návesťou pred križovatkou,",
               "je smerovou tabuľou s diaľkovým cieľom.",
               1);

       quest[20] = new Questions("Táto dopravná značka znamená:",
               "Koniec viacerých zákazov,",
               "Koniec obce,",
               "Koniec obytnej zóny.",
               2);

       quest[21] = new Questions("Táto dodatková tabuľka vyznačuje",
               "vzdialenosť k miestu, od ktorého začína platiť značka, pod ktorou je tabuľka umiestnená,",
               "smer obchádzky,",
               "úsek, pre ktorý platí značka, pod ktorou je tabuľka umiestnená.",
               3);

       quest[22] = new Questions("Takéto označenie sa musí použiť na",
               "autobuse prepravujúcom deti,",
               "vyznačenie úseku cesty so zvýšeným pohybom detí (v blízkosti školských a predškolských zariadení, detských ihrísk a podobne),",
               "osobnom automobile prepravujúcom deti.",
               1);

       quest[23] = new Questions("Ako prvé vojde do križovatky",
               "zelené vozidlo,",
               "modré vozidlo,",
               "červené vozidlo.",
               3);

       quest[24] = new Questions("Ak má policajt pravú ruku predpaženú a ľavú upaženú, znamená to „Stoj!” pre",
               "vodiča zeleného vozidla,",
               "vodiča červeného a vodiča žltého vozidla,",
               "chodcov prechádzajúcich za chrbtom policajta.",
               2);

       quest[25] = new Questions("Vaše vozidlo prejde cez križovatku ako",
               "prvé,",
               "posledné,",
               "druhé.",
               2);

       quest[26] = new Questions("Vozidlá prejdú cez križovatku v tomto poradí:",
               "1. električka, 2. zelené, 3. modré, 4. žlté, 5. vaše vozidlo,",
               "1. zelené, 2. električka, 3. modré, 4. žlté, 5. vaše vozidlo,",
               "1. modré, 2. zelené, 3. žlté, 4. vaše vozidlo, 5. električka.",
               1);

   }



}
