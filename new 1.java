package provaLP;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

 

public class Janela {

 

    private String material;
    private Double Largura;
    private Double altura;
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Double getLargura() {
        return largura;
    }
    public void setlargura(Double largura) {
        this.largura = largura;
    }
    public Double getAltura() {
        return altura;
    }
    public void setAltura(Double altura) {
        this.altura = altura;
    }
    public Janela(String material, Double largura, Double altura) {
        super();
        this.material = material;
        this.largura = largura;
        this.altura = altura;
    }

    public void informaMaterial() {
        System.out.println("O material da janela é " +  material);
    }

    public void Conexao() {
        String sql = "INSERT INTO janela(material, largura, altura) VALUES(?,?,?)";
        try {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prova", "postgres", "4321");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, material);
        ps.setString(2, largura);
        ps.setString(3, altura);
        ps.execute();
        con.commit();
        con.close();
        System.out.println("Cadastrado com sucesso!");
        } catch (Exception e2) {
            // TODO: handle exception
        }
    }

 

}