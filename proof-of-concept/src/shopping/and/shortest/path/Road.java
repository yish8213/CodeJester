package shopping.and.shortest.path;

import java.util.Objects;

/**
 * Created by y1sh on 9/20/16.
 */
public class Road {
    private final int destinationShopId;
    private final int travelTime;

    public Road(int destinationShopId, int travelTime) {
        this.destinationShopId = destinationShopId;
        this.travelTime = travelTime;
    }

    public int getDestinationShopId() {
        return destinationShopId;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return destinationShopId == road.destinationShopId &&
                travelTime == road.travelTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationShopId, travelTime);
    }
}
