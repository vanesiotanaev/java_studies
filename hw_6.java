import java.util.ArrayList;

public class hw_6 {
  public static void main(String[] args) {
    
    Infrastructure infrastructure = new Infrastructure();

    // Метод для поиска фильма (домашняя работа)

    infrastructure.search("LO");
   
  }
}

class Infrastructure {
  public Infrastructure() {
    init();
  }

  Db db;

  public Db getDb() {
    return db;
  }

  public String getAllInfo(int idCinema) {
    Cinema c = db.films.get(idCinema - 1);

    return String.format("%d %s %s %s",
        c.id,
        c.name,
        db.genres.get(c.genre - 1).name,
        db.prod.get(c.filmProd - 1).titleName);
  }

  public char[] wordToChar(String word){
    char[] ch = word.toCharArray();
    return ch;
  }

  // Метод для поиска фильма (домашняя работа)

  public void search(String word){
    ArrayList<String> searchResult = new ArrayList<>();
    for (int i = 1; i <= db.films.size(); i++){
        String res = getAllInfo(i);
        boolean check = res.contains(word);
        if (check == true){
            searchResult.add(res + "\n");
            System.out.println(getAllInfo(i));
        }
    }
  }

  Db init() {
    db = new Db();
    Cinema c1 = new Cinema(1, "LOST", 1, 1);
    Cinema c2 = new Cinema(2, "The Office", 3, 2);
    Cinema c3 = new Cinema(3, "Neighbors 2", 3, 4);
    Cinema c4 = new Cinema(4, "Yes", 3, 3);

    db.films.add(c1);
    db.films.add(c2);
    db.films.add(c3);
    db.films.add(c4);
    


    db.genres.add(new Genre(1, "Drama"));
    db.genres.add(new Genre(2, "Thriller"));
    db.genres.add(new Genre(3, "Comedy"));
    FilmProducerFactory pf = new FilmProducerFactory();
    db.addFilmProducer(pf.getFilmProducer("20th Century"));
    db.addFilmProducer(pf.getFilmProducer("Paramount"));
    db.addFilmProducer(pf.getFilmProducer("Lionsgate"));
    db.addFilmProducer(pf.getFilmProducer("Universal"));

    return db;
  }
}

class Db {
  ArrayList<Cinema> films = new ArrayList<>();
  ArrayList<FilmProducer> prod = new ArrayList<>();
  ArrayList<Genre> genres = new ArrayList<>();

  public void addFilmProducer(FilmProducer producer) {
    prod.add(producer);
  }
}

class Cinema {
  int id;
  int filmProd;
  String name;
  int genre;

  public Cinema(int id, String name, int genre, int filmProd) {
    this.id = id;
    this.filmProd = filmProd;
    this.name = name;
    this.genre = genre;
  }
}

class FilmProducer {
  int id;
  String titleName;
}

class Genre {
  int id;
  String name;

  public Genre(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

class FilmProducerFactory {
  int count = 1;

  public FilmProducer getFilmProducer(String name) {
    FilmProducer fp = new FilmProducer();
    fp.id = count++;
    fp.titleName = name;
    return fp;
  }
}