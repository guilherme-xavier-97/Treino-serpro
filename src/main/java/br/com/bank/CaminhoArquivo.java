package br.com.bank;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {
        String b = "/tmp/";
        String d = null;
        String n = null;
        int div =-Math.floorDiv(-id, 1000);

        d=b+div+"/";
        n = d+id; 

        if(id.equals(null)) {
            throw new NullPointerException();
        }     

        return new CaminhoArquivo(Paths.get(d), Paths.get(n));

    }

    }
