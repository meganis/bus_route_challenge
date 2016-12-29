# Bus Route Challenge

### Problem

See [Bus Route Challenge]{https://github.com/goeuro/challenges/tree/master/bus_route_challenge}

### Solution

Solution uses arrays of BitSets, representing buses arriving at each station. This results in memory consumption of approximately:
4 * 1,000,000 (array of stations, constant size) + (N / 64 + overhead of BitSet) * num_of_stations, giving about 1.6 GB upper boundary.

Determining the result uses single simultaneous iteration over 2 arrays, finding first common station, by means of bitwise AND, performing at most N/64 iterations.
So the time cost grows linear.
