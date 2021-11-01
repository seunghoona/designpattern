package composite;

import composite.Waitress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitressTest {
    @Test
    void name() {
        MenuComponet starbuks = new Menu("스타벅스", "아침메뉴");
        MenuComponet ediya = new Menu("이디야", "점심");
        MenuComponet twosome = new Menu("투썸", "저녁메뉴");
        MenuComponet menuComponet = new Menu("전체메뉴","전체메뉴");
        menuComponet.add(starbuks);
        menuComponet.add(ediya);
        menuComponet.add(twosome);
        twosome.add(new MenuItem("치킨","존맛탱",false,2_000));
        twosome.add(new MenuItem("치킨","존맛탱",false,2_000));
        Waitress waitress = new Waitress(menuComponet);
        waitress.printMenu();
    }
}