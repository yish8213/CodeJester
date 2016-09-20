package shopping.and.shortest.path;

import java.util.Comparator;

/**
 * Created by y1sh on 9/20/16.
 */
public class TravelTimeComparator implements Comparator<TravelTimeForEachShopOnThePath> {

    @Override
    public int compare(TravelTimeForEachShopOnThePath x, TravelTimeForEachShopOnThePath y) {
        if (x.getAccumulatedTravelTime() < y.getAccumulatedTravelTime()) {
            return -1;
        }

        if (x.getAccumulatedTravelTime() > y.getAccumulatedTravelTime()) {
            return 1;
        }

        return 0;
    }
}
