
import java.util.Scanner;


public class TvRemoteControlDemo {
 public static void main(String[] args) {
     // Create the TV and commands
     Tv livingRoomTv = new Tv();
     TvOnCommand tvOn = new TvOnCommand(livingRoomTv);
     TvOffCommand tvOff = new TvOffCommand(livingRoomTv);
//     TvChannelUpCommand channelUp = new TvChannelUpCommand(livingRoomTv);
//     TvChannelDownCommand channelDown = new TvChannelDownCommand(livingRoomTv);
//     TvVolumeUpCommand volumeUp = new TvVolumeUpCommand(livingRoomTv);
//     TvVolumeDownCommand volumeDown = new TvVolumeDownCommand(livingRoomTv);

     // Create the remote control
     RemoteControl remote = new RemoteControl();

     // Menu-driven program
     Scanner scanner = new Scanner(System.in);
     int choice = 0; // Initialize choice with a default value

     do {
         System.out.println("\nTV Remote Control Menu:");
         System.out.println("1. Turn On TV");
         System.out.println("2. Turn Off TV");
//         System.out.println("3. Channel Up");
//         System.out.println("4. Channel Down");
//         System.out.println("5. Volume Up");
//         System.out.println("6. Volume Down");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");

         if (scanner.hasNextInt()) {
             choice = scanner.nextInt();
             switch (choice) {
                 case 1:
                     remote.setCommand(tvOn);
                     remote.pressButton();
                     break;
                 case 2:
                     remote.setCommand(tvOff);
                     remote.pressButton();
                     break;
//                 case 3:
//                     remote.setCommand(channelUp);
//                     remote.pressButton();
//                     break;
//                 case 4:
//                     remote.setCommand(channelDown);
//                     remote.pressButton();
//                     break;
//                 case 5:
//                     remote.setCommand(volumeUp);
//                     remote.pressButton();
//                     break;
//                 case 6:
//                     remote.setCommand(volumeDown);
//                     System.out.println("Volume is set to 6.");
//                     remote.pressButton();
//                     
//                     break;
                 case 3:
                     System.out.println("Exiting the TV remote control.");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } else {
             System.out.println("Invalid input. Please enter a number.");
             scanner.next(); // Consume invalid input
         }
     } while (choice != 3);

     scanner.close();
 }
}
//Command interface
interface Command {
 void execute();
}

//Concrete command: Turn on the TV
class TvOnCommand implements Command {
 private Tv tv;

 public TvOnCommand(Tv tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.turnOn();
 }
}

//Concrete command: Turn off the TV
class TvOffCommand implements Command {
 private Tv tv;

 public TvOffCommand(Tv tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.turnOff();
 }
}

//Concrete command: Change channel up
//class TvChannelUpCommand implements Command {
// private Tv tv;
//
// public TvChannelUpCommand(Tv tv) {
//     this.tv = tv;
// }
//
// @Override
// public void execute() {
//     tv.channelUp();
// }
//}
//
////Concrete command: Change channel down
//class TvChannelDownCommand implements Command {
// private Tv tv;
//
// public TvChannelDownCommand(Tv tv) {
//     this.tv = tv;
// }
//
// @Override
// public void execute() {
//     tv.channelDown();
// }
//}
//
////Concrete command: Increase volume
//class TvVolumeUpCommand implements Command {
// private Tv tv;
//
// public TvVolumeUpCommand(Tv tv) {
//     this.tv = tv;
// }
//
// @Override
// public void execute() {
//     tv.volumeUp();
// }
//}
//
////Concrete command: Decrease volume
//class TvVolumeDownCommand implements Command {
// private Tv tv;
//
// public TvVolumeDownCommand(Tv tv) {
//     this.tv = tv;
// }
//
// @Override
// public void execute() {
//     tv.volumeDown();
// }
//}

//Receiver: The TV
class Tv {
// private int currentChannel = 1;
// private int currentVolume = 10;
 private boolean isOn = false;

 public void turnOn() {
     isOn = true;
     System.out.println("TV is ON");
 }

 public void turnOff() {
     isOn = false;
     System.out.println("TV is OFF");
 }

// public void channelUp() {
//     if (isOn) {
//         currentChannel++;
//         System.out.println("Channel up. Current channel: " + currentChannel);
//     }
// }
//
// public void channelDown() {
//     if (isOn) {
//         currentChannel--;
//         System.out.println("Channel down. Current channel: " + currentChannel);
//     }
// }
//
// public void volumeUp() {
//     if (isOn) {
//         currentVolume++;
//         System.out.println("Volume up. Current volume: " + currentVolume);
//     }
// }
//
// public void volumeDown() {
//     if (isOn) {
//         currentVolume--;
//         System.out.println("Volume down. Current volume: " + currentVolume);
//     }
// }
}

//Invoker: Controls the commands
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}
