package shopping.and.shortest.path;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by y1sh on 9/19/16.
 */
public class SynchronousShopping {
    private static final int MAX_SHOP_COUNT = 1000;
    private static final int MAX_ACCUMULATED_FISH_TYPE_MASK = 1023; // 1111111111
    private static final int MAX_TRAVEL_TIME = 20000000;

    private static int sellingFishTypesAtShop[] = new int[MAX_SHOP_COUNT];
    private static int shortestPathForEachShop[][] = new int[MAX_SHOP_COUNT][MAX_ACCUMULATED_FISH_TYPE_MASK + 1];
    private static Map<Integer, HashSet<Road>> roads = new HashMap<>();
    private static PriorityQueue<TravelTimeForEachShopOnThePath> queue = new PriorityQueue<>(new TravelTimeComparator());

    private static void enQueue(int shopId, int travelTime, int accumulatedFishTypeMask) {
        if (shortestPathForEachShop[shopId - 1][accumulatedFishTypeMask] <= travelTime) { // We don't need to consider a case of spending more travel time to the same shop with accumulated fish type.
            return;
        }

        TravelTimeForEachShopOnThePath current = new TravelTimeForEachShopOnThePath(shopId, shortestPathForEachShop[shopId - 1][accumulatedFishTypeMask], accumulatedFishTypeMask);

        shortestPathForEachShop[shopId - 1][accumulatedFishTypeMask] = travelTime;
        current.setAccumulatedTravelTime(travelTime);
        queue.add(current);

    }

    private static void performDijkstra(int shopId) {
        enQueue(shopId, 0, sellingFishTypesAtShop[shopId - 1]);
        while (!queue.isEmpty()) {
            TravelTimeForEachShopOnThePath currentShoppingCenter = queue.poll();
            int travelTime = currentShoppingCenter.getAccumulatedTravelTime();
            int currentFishTypeMask = currentShoppingCenter.getAccumulatedFishTypeMask();
            shopId = currentShoppingCenter.getShopId();

            roads.get(shopId)
                    .forEach(neighborPath ->
                            enQueue(neighborPath.getDestinationShopId(), travelTime + neighborPath.getTravelTime(), currentFishTypeMask | sellingFishTypesAtShop[neighborPath.getDestinationShopId() - 1])
                    );

        }
    }

    private static void initializeArrays() {
        Arrays.fill(sellingFishTypesAtShop, 0);
        IntStream.range(0, MAX_SHOP_COUNT)
                .parallel()
                .forEach(node -> Arrays.fill(shortestPathForEachShop[node], MAX_TRAVEL_TIME));
    }

    private static void addRoadValues(int key, Road value) {
        HashSet<Road> tempSet;

        if (roads.containsKey(key)) {
            tempSet = roads.get(key);
            tempSet.add(value);
        } else {
            tempSet = new HashSet<>();
            tempSet.add(value);
        }

        roads.put(key, tempSet);
    }

    // https://www.hackerrank.com/challenges/synchronous-shopping
    public static void main(String[] args) {
        initializeArrays();
        Scanner stdInput = new Scanner(System.in);

        int totalNumberOfShoppingCenters = stdInput.nextInt();
        int totalNumberOfRoads = stdInput.nextInt();
        int totalNumberOfTypesOfFish = stdInput.nextInt();

        /*
            A maximum number of type of fish is 10. We can express this by the binary masking.
            For example, if you have 1, 5, 7 types of fish. Binary mask value is 0001010001
         */
        for (int i = 0; i < totalNumberOfShoppingCenters; i++) {
            int numberOfTypesOfFishForEachVertex = stdInput.nextInt();
            int accumulatedFishTypeMask = 0;

            for (int j = 0; j < numberOfTypesOfFishForEachVertex; j++) {
                accumulatedFishTypeMask |= (1 << (stdInput.nextInt() - 1));
            }

            sellingFishTypesAtShop[i] = accumulatedFishTypeMask;
        }

        for (int i = 0; i < totalNumberOfRoads; i++) {
            int sourceShopId = stdInput.nextInt();
            int destinationShopId = stdInput.nextInt();
            int travelTime = stdInput.nextInt();

            addRoadValues(sourceShopId, new Road(destinationShopId, travelTime));
            addRoadValues(destinationShopId, new Road(sourceShopId, travelTime));
        }

        performDijkstra(1); // Start from 1 and the final destination is biggest shop id.

        int bestTime = MAX_TRAVEL_TIME;

        for (int i = 0; i < (1 << totalNumberOfTypesOfFish); i++) {
            for (int j = i; j < (1 << totalNumberOfTypesOfFish); j++) {
                if ((i | j) == (1 << totalNumberOfTypesOfFish) - 1) {
                    int timeToComparison = shortestPathForEachShop[totalNumberOfShoppingCenters - 1][i] > shortestPathForEachShop[totalNumberOfShoppingCenters - 1][j] ?
                            shortestPathForEachShop[totalNumberOfShoppingCenters - 1][i] : shortestPathForEachShop[totalNumberOfShoppingCenters - 1][j];
                    bestTime = timeToComparison < bestTime ? timeToComparison : bestTime;
                }
            }
        }

        System.out.println(bestTime);
    }
}