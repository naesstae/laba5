package allForDragons;

import java.util.Comparator;
/**Компаратор для сравнения драконов по количеству глаз*/
public class HeadComparator implements Comparator<Dragon> {
    @Override
    public int compare(Dragon dragon1, Dragon dragon2) {
        int result = 0;
        if (dragon1.getHead().getEyesCount() < dragon2.getHead().getEyesCount()) {
            result = -1;
        }
        if (dragon1.getHead().getEyesCount() > dragon2.getHead().getEyesCount()) {
            result = 1;
        }
        return result;
    }
}
