object main {
  import scala.io.StdIn.readInt
  import scala.collection.immutable._
  import scala.collection.mutable.ListBuffer
  
  def main(arg: Array [String]){
    print("Seat Reservation Problem\n\n")
    
    println("Let's assume there are 40 seats")
    println("In this problem we consider oneway route with fixed pickup and destination points\n")
    println("For demonstration pourposes I have initialize some seats with pre define code\n")
    
    println("Following are the pickup and destination points")
    
    printDestinations();
    
    println("Let's get started")
    
    var option = 1;
    
    var reserveList = new ListBuffer[List[Int]]()
    reserveList = addDefaultReservations(reserveList)
    
    while(option != 3){
      println("1 - Reserve a seat")
      println("2 - Print destinations")
      println("3 - Exit")
      
      print("Enter your option : ");
      option = readInt();
      
      option match{
        case 1 => reservation(reserveList)
        case 2 => printDestinations()
        case 3 => println("Exit")
        case _ => println("Invalid Input\n")
      }
    }
    
  }
  
  def printDestinations():Unit ={
    println("\t1. Sri Lanka\n" + "\t2. Singapore\n" + "\t3. Australia\n" + "\t4. China\n" + "\t5. Japan\n" + 
        "\t6. Korea\n" + "\t7. Russia\n" + "\t8. England\n" + "\t9. USA\n" + "\t10. Canada\n" )
  }
  
  def reservation(l:ListBuffer[List[Int]]): ListBuffer[List[Int]] = {
    
    print("\nEnter pickup point : ");
    var pickup = readInt();
    
    print("Enter destination point : ");
    var dest = readInt();
    
    while(pickup<=0 || pickup>=10 || dest<=1 || dest>10 || pickup >= dest){
      if(pickup<=0 || pickup>10){
        println("Pickup point could be numbers from 1-9")
      }else if(pickup==10){
        println("Pickup point cannot be the last destination point")
      }
      if(dest==1){
        println("Destination point cannot be the first destination point")
      }else if(dest<1 || dest>10){
        println("Destination point could be numbers from 2-10")
      }
      if(pickup == dest) {
        println("Pickup point and Destination point cannot be the same")
      }else if(pickup>dest){
        println("This is one way route you cannot travel backword")
      }
      println()
      print("Enter pickup point : ")
      pickup = readInt();
      print("Enter destination point : ")
      dest = readInt();
    }
    println();
    var seats = getSeats(pickup,dest,l)
    
    print("Choose a seat for reserve : ")
    var seat = readInt();
    while(seat<=0 || seat>40 || seats((seat-1)/4)((seat-1)%4) == 1){
      if(seat<=0 || seat>40){
        println("There are only maximum of 40 seats")
      }else{
        println("Allready reserved pick another seat")
      }
      print("Choose a seat for reserve : ")
      seat = readInt();
    }
    
    println("Seat_No "+seat+" Reserved\n")
    l += List(pickup,dest,seat)
    return l;
    
  }
  
  def getSeats(s:Int, d:Int, l:ListBuffer[List[Int]]): Array[Array[Int]] = {
    var seats = Array.ofDim[Int](10,4);
    for(litem <- l){
      if(!((litem(0)<s && litem(1)<=s) || (litem(0)>=d && litem(1)>d))){
        seats((litem(2)-1)/4)((litem(2)-1)%4) = 1;
      }
    }
    
//    println("\tColumn_1\t"+"column_2\t"+"Column_3\t"+"Column_4")
    for(i <- 0 to 9){
//      print("Row_"+(i+1)+"\t")
      for(j <- 0 to 3){
        if(seats(i)(j) == 0){
          print("Seat_No "+(i*4+j+1) + " - Free\t")
        }else{
          print("Seat_No "+(i*4+j+1) + " - Reserved\t")
        }
      }
      println();
    }
    return seats;
  }
  
  def addDefaultReservations(l:ListBuffer[List[Int]]): ListBuffer[List[Int]] = {
    l += (List(1,6,5),List(1,8,10),List(1,10,20),List(3,5,1),List(3,10,8),List(3,8,25),
        List(5,6,40),List(5,9,12),List(5,8,15),List(7,10,14),List(7,9,18),List(7,8,23),
        List(6,8,2),List(4,10,35),List(2,6,31))
    return l;
  }
  
}