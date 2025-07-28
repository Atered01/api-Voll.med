package med.vol.api.domain.medico;

import java.util.Arrays;

public enum Especialidade {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    private String especialidades;

     Especialidade(String especialidades) {
        this.especialidades = especialidades;
    }

    public static Especialidade fromString(String text){
         return Arrays.stream(Especialidade.values())
                 .filter(e -> e.especialidades.equalsIgnoreCase(text))
                 .findFirst()
                 .orElseThrow(() -> new IllegalArgumentException("Nenhuma especialidade encontrada"));
    }
}
