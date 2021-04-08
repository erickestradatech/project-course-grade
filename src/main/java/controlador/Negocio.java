package controlador;

import modelo.*;
import java.util.*;
import java.sql.*;
import util.MySQLConexion;

public class Negocio {

    public List<Curso_Nota> LisNotas(String cod) {

        List<Curso_Nota> lis = new ArrayList<>();
        Connection conn = null;

        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT C.IdCurso,C.NomCurso,N.ExaParcial,N.ExaFinal\n"
                    + "FROM  CURSO C, NOTAS N WHERE C.IdCurso=N.IdCurso\n"
                    + "AND N.IdAlumno=?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Curso_Nota a = new Curso_Nota();
                a.setCodc(rs.getString(1));
                a.setNomc(rs.getString(2));
                a.setEp(rs.getInt(3));
                a.setEf(rs.getInt(4));
                lis.add(a);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {

                    conn.close();
                }

            } catch (Exception e2) {

            }
        }

        return lis;
    }

    public List<Alu_Nota> LisAluNota(String cod) {

        List<Alu_Nota> lis = new ArrayList<>();
        Connection conn = null;

        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT a.IdAlumno,a.ApeAlumno,a.NomAlumno,e.Nomesp,N.ExaParcial,N.ExaFinal\n"
                    + "FROM Alumno a, Especialidad e, NOTAS N WHERE a.Idesp=e.Idesp\n"
                    + "and a.IdAlumno = n.IdAlumno and n.IdCurso=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Alu_Nota a = new Alu_Nota();
                a.setCoda(rs.getString(1));
                a.setApe(rs.getString(2));
                a.setNoma(rs.getString(3));
                a.setNomesp(rs.getString(4));
                a.setEp(rs.getInt(5));
                a.setEf(rs.getInt(6));
                lis.add(a);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return lis;
    }

    public List<Alu_Pago> LisAluPago(String cod) {

        List<Alu_Pago> lis = new ArrayList<>();
        Connection conn = null;

        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT a.IdAlumno,a.ApeAlumno,a.NomAlumno,e.Nomesp,p.CICLO,p.FECHA,p.MONTO\n"
                    + "FROM Alumno a, Especialidad e, pagos p WHERE a.IdAlumno=p.IdAlumno\n"
                    + "AND a.Idesp = e.Idesp AND a.IdAlumno=?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Alu_Pago a = new Alu_Pago();
                a.setCoda(rs.getString(1));
                a.setApe(rs.getString(2));
                a.setNoma(rs.getString(3));
                a.setNomesp(rs.getString(4));
                a.setCiclo(rs.getInt(5));
                a.setFecha(rs.getString(6));
                a.setMonto(rs.getDouble(7));
                lis.add(a);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {

            }
        }

        return lis;
    }

}
