package tema3;

public class estantes {
    public static void main(String[] args) {  
        estante est = new estante();
        
        
        
        Autor autor1 = new Autor("Herbert Schildt"," nacio el año tal,murio el año tal","nacio en alemania");
        Autor autor2 = new Autor("John Horton"," nacio el año tal,murio el año tal","nacio en francia");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                 autor1, "978-0071809252", 21.72);
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               autor2, "978-1512108347");
        Autor autor3 = new Autor("John Horton"," nacio el año tal,murio el año tal","nacio en francia");
        Libro libro3= new  Libro( "mujercitas",   
                                 "Mcgraw-Hill", 2014,   
                                 autor3, "978-0071809252", 21.72);
        
        est.setLibroEnEstante(libro1);
        est.setLibroEnEstante(libro2);
        est.setLibroEnEstante(libro3);
        est.setLibroEnEstante(libro2);
        est.setLibroEnEstante(libro2);
        
        System.out.println(est.getCantLibros());
        System.out.println(est.getEstaLLeno());
        est.getLibroDeEsteTitulo("mujercitas").getPrimerAutor();
        //buscado.getPrimerAutor();
    }

}
