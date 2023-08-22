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
        String diretorio_raiz = "/tmp/";
        String diretorio_especifico = null;
        String auxiliar = null;
        int divisor =-Math.floorDiv(-id, 1000);

        diretorio_especifico=diretorio_raiz+divisor+"/";
        auxiliar = diretorio_especifico+id; 

        if(id.equals(null)) {
            throw new NullPointerException();
        }     

        return new CaminhoArquivo(Paths.get(diretorio_especifico), Paths.get(auxiliar));

    }

    }
