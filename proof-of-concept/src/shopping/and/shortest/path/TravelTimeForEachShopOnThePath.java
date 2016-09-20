package shopping.and.shortest.path;

import java.util.Objects;

/**
 * Created by y1sh on 9/20/16.
 */
public class TravelTimeForEachShopOnThePath {
    private int shopId;
    private int accumulatedTravelTime;
    private int accumulatedFishTypeMask;

    public TravelTimeForEachShopOnThePath(int shopId, int accumulatedTravelTime, int accumulatedFishTypeMask) {
        this.shopId = shopId;
        this.accumulatedTravelTime = accumulatedTravelTime;
        this.accumulatedFishTypeMask = accumulatedFishTypeMask;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getAccumulatedTravelTime() {
        return accumulatedTravelTime;
    }

    public void setAccumulatedTravelTime(int accumulatedTravelTime) {
        this.accumulatedTravelTime = accumulatedTravelTime;
    }

    public int getAccumulatedFishTypeMask() {
        return accumulatedFishTypeMask;
    }

    public void setAccumulatedFishTypeMask(int accumulatedFishTypeMask) {
        this.accumulatedFishTypeMask = accumulatedFishTypeMask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelTimeForEachShopOnThePath that = (TravelTimeForEachShopOnThePath) o;
        return shopId == that.shopId &&
                accumulatedTravelTime == that.accumulatedTravelTime &&
                accumulatedFishTypeMask == that.accumulatedFishTypeMask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, accumulatedTravelTime, accumulatedFishTypeMask);
    }
}
