class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Double[][] cars = new Double[n][2];

        for(int i =0; i<n; i++){
            cars[i][0] = (double)position[i];
            cars[i][1] = (double)(target-position[i])/speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        int fleet = 0;
        double lastTime = -1;
        for(Double[]car: cars){
            if(car[1] > lastTime){
                fleet++;
                lastTime = car[1];
            }
        }

        return fleet;
    }
}
