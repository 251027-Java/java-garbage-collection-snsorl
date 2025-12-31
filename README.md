1. How many Minor GCs occurred? 8
2. How many Major/Full GCs occurred? 10
3. What was the longest GC pause time? 9.563 ms


| GC Type | Total GC Events |        Longest Pause       | Throughput |
|---------|-----------------|----------------------------|------------|
| Serial  |        6        |    70.710                  |    99.8    |
| G1GC    |       22        |    92.739                  |    99.77   |
| ZGC     |       27        |   0.104 (internal)         |    99.99   |
| ZGC     |                 |  29.840 (allocation stall) |	      |

1. Did G1GC achieve the target pause time? Yes, all are under 100 milliseconds.
2. What trade-offs did you observe? More CPU needed for more Garbage Collection events

