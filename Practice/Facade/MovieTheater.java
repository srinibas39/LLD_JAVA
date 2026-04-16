package Practice.Facade;

// Home theater Facade practice: subsystem classes + HomeTheaterFacade orchestrates watch/end flows.

class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }

    public void off() {
        System.out.println("Amplifier off");
    }

    public void setVolume(int volume) {
        System.out.println("Amplifier volume set to " + volume);
    }
}

class DvdPlayer {
    public void on() {
        System.out.println("DvdPlayer on");
    }

    public void off() {
        System.out.println("DvdPlayer off");
    }

    public void play(String title) {
        System.out.println("DvdPlayer playing \"" + title + "\"");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector on");
    }

    public void off() {
        System.out.println("Projector off");
    }

    public void setWideScreenMode() {
        System.out.println("Projector in wide-screen mode");
    }
}

class TheaterLights {
    public void dim(int level) {
        System.out.println("Theater lights dim to " + level + "%");
    }
}

class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final DvdPlayer dvdPlayer;
    private final Projector projector;
    private final TheaterLights theaterLights;

    public HomeTheaterFacade() {
        this.amplifier = new Amplifier();
        this.dvdPlayer = new DvdPlayer();
        this.projector = new Projector();
        this.theaterLights = new TheaterLights();
    }

    public void watchMovie(String title) {
        System.out.println("Get ready to watch a movie...");
        theaterLights.dim(10);
        projector.on();
        projector.setWideScreenMode();
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(title);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        theaterLights.dim(100);
    }
}

public class MovieTheater {
    public static void main(String[] args) {
        
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.watchMovie("The Dark Knight");
        homeTheaterFacade.endMovie();
    }
}
