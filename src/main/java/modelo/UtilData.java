package modelo;

import com.google.protobuf.TextFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Classe para manipular datas.
 */
public class UtilData {

    /**
     * Método para obter a data atual.
     * @return A data atual no formato SQL.
     */
    public static Date dataAtual() {
        LocalDate hoje = LocalDate.now();
        return Date.valueOf(hoje);
    }

    /**
     * Método para converter uma string em uma data SQL.
     * @param dataString A data como uma string no formato "yyyy-MM-dd".
     * @return A data no formato SQL.
     * @throws TextFormat.ParseException Se a dataString não estiver no formato correto.
     * @throws java.text.ParseException Se a dataString não puder ser convertida em uma data.
     */
    public static Date stringParaDateSQL(String dataString) throws TextFormat.ParseException, java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataUtil = formato.parse(dataString);
        return new Date(dataUtil.getTime());
    }

}
