# Seat-Reservation
In this repository I have develop a CLI application to optimize the availability of seats for passengers in Airplane for different destinations.

> Need Scala version equal or upper than : **2.13.5**

## Solution
I will store the reservation details of the airplane in a **ListBuffer[List[Source, Destination, SeatNumber]]**.

![alt text](img/Picture1.png?raw=true "Array initialization")

I have initialized it with pre-defined reservations for demonstration pourposes. Assume that there are only 40 seats available in any air plane.

![alt text](img/Picture2.png?raw=true "function addDefaultReservations")

#### Pre defined Destination List

1. Sri Lanka
2. Singapore
3. Australia
4. China
5. Japan
6. Korea
7. Russia
8. England
9. USA
10. Canada

#### Output look like this

| Person | Source | Destination | Seat No |            
| :----: |:------:| :----------:| :-----: |
| 1 | 1-Sri Lanka | 1-Sri Lanka | 5 |
| 2 | 1-Sri Lanka | 8-England | 10 |
| 3 | 1-Sri Lanka | 10-Canada | 20 |
| 4 | 3-Australia | 5-Japan | 1 |
| 5 | 3-Australia | 10-Canada | 8 |
| 6 | 3-Australia | 8-England | 25 |
| 7 | 5-Japan | 6-Korea | 40 |
| 8 | 5-Japan | 9-USA | 12 |
| 9 | 5-Japan | 8-England | 15 |
| 10 | 7-Russia | 10-Canada | 14 |
| 11 | 7-Russia | 9-USA | 18 |
| 12 | 7-Russia | 8-England | 23 |
| 13 | 6-Korea | 8-England | 2 |
| 14 | 4-China | 10-Canada | 35 |
| 15 | 2-Singapore | 6-Korea | 31 |

#### Our loop structure

![alt text](img/Picture3.png?raw=true "loop structure")

### 1. Reserve a Seat

Here I will ask pickup and destination point then system will filter out available seats and let us to choose a seat number.
If you try to reserve already reserved seat system will give warning that the seat is reserved. 
Here I have take care of following constrains before filtering out available seats.
  * Pickup point should be a number in destination column
  * Pickup point cannot be last destination point
  * Destination cannot be first destination
  * Destination point should be a number in destination column
  * Pickup point and destination point cannot be the same
  * Pickup point should always lower than destination point

![alt text](img/Picture4.png?raw=true "function reservation")

### 2. Get Available Seats

Get available seats are somewhat tricky. Here I have pass our ListBuffer to that function.
Then I have created a 2D array of size 10x4. In that array Update value of each cell to one if seats are not available and with zeros if seats are available.
Here I have take care of following constrains,
  * For each reservation, if our start point is not greater that both pickup and destination then seat correspond to that reservation are not available
  * For each reservation, if our end point is not less that both pickup and destination then seat correspond to that reservation are not available

![alt text](img/Picture5.png?raw=true "function Available Seats")

### 3. Print Destination

This will print the destination point where the airplane start/stops.

![alt text](img/Picture6.png?raw=true "function getSeats")

