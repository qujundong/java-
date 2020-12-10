package item36;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author: qujundong
 * @date: 2020/12/5 下午9:44
 * @description:
 */
public class Text {
    private enum Style{BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    public static void main(String[] args) {
        EnumSet<Style> styles = EnumSet.noneOf(Style.class);
        System.out.println(styles);
        styles.add(Style.BOLD);
        styles.add(Style.ITALIC);
        System.out.println(styles);

        EnumSet<Style> styles1 = EnumSet.allOf(Style.class);
        System.out.println(styles1);

        EnumSet<Style> styles2 = EnumSet.range(Style.BOLD, Style.UNDERLINE);
        System.out.println(styles2);

        EnumSet<Style> styles3 = EnumSet.complementOf(styles2);
        System.out.println(styles3);

        EnumSet<Style> styles4 = EnumSet.copyOf(styles3);
        System.out.println(styles4);

    }
}
