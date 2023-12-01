
//Main class
public class AdapterPatternDemo {
 public static void main(String[] args) {
     Heart heart = new Heart();
     Beat beat = new Beat();
     HeartAdapter adapter = new HeartAdapter(heart);

     // Use the Heart Model as if it were a Beat Model
     int bpm = adapter.getBPM();
     System.out.println("Initial BPM: " + bpm);

     // Simulate changing heart rate data and updating the BPM
     heart.generateHeartRate();
     bpm = adapter.getBPM();
     beat.setBPM(bpm);
 }
}


//Heart Model interface
interface HeartModel {
 int getHeartRate();
}

//Heart Model Implementation
class Heart implements HeartModel {
 private int heartRate;

 public Heart() {
     // Simulate heart rate data (e.g., from a sensor)
     this.heartRate = 0;
 }

 public int getHeartRate() {
     return heartRate;
 }

 // Simulate changing heart rate data
 public void generateHeartRate() {
     heartRate = (int) (Math.random() * 100 + 60); // Generate a random heart rate between 60 and 160
     System.out.println("Heart rate: " + heartRate + " bpm");
 }
}

//Beat Model interface
interface BeatModel {
 void setBPM(int bpm);
 int getBPM();
}

//Beat Model Implementation
class Beat implements BeatModel {
 private int bpm;

 public void setBPM(int bpm) {
     this.bpm = bpm;
     System.out.println("BPM set to " + bpm);
 }

 public int getBPM() {
     return bpm;
 }
}

//Adapter to adapt Heart Model to Beat Model
class HeartAdapter implements BeatModel {
 private HeartModel heartModel;

 public HeartAdapter(HeartModel heartModel) {
     this.heartModel = heartModel;
 }

 public void setBPM(int bpm) {
     // Heart rate doesn't have a set BPM, so we'll ignore this method
     System.out.println("Cannot set BPM on Heart Model");
 }

 public int getBPM() {
     int heartRate = heartModel.getHeartRate();
     return heartRate;
 }
}

