package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.DbAccess;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlProfileDAO implements ProfileDAO {

    private static SqlProfileDAO instance;

    public static SqlProfileDAO getInstance() {
        if(instance == null) instance = new SqlProfileDAO();
        return instance;
    }

    private DbAccess dbAccess = DbAccess.getInstance();

    private SqlProfileDAO() {
        //TODO initialize connection to database
        String selectQuery = "SELECT * FROM utilisateur";

    }

    @Override
    public ProfileDTO findById(Long aLong) {
        String selectQuery = "SELECT * FROM utilisateur";

        return null;
    }

    public ProfileDTO findByEmail(String email) {
        String selectQuery = "SELECT * FROM utilisateur";

        return null;
    }

    @Override
    public ProfileDTO findByEmailAndPassword(String email, String passsword) {
        String selectQuery = "SELECT * FROM utilisateur";

        return null;
    }

    @Override
    public boolean updatePassword(String email, String oldPass, String newPass) {

        return false;
    }

    @Override
    public List<ProfileDTO> findAll() {
        String selectQuery = "SELECT * FROM utilisateur";
        List<ProfileDTO> listUtilisateur = new ArrayList<>();
        try {
            PreparedStatement stmt = dbAccess.getCon().prepareStatement(selectQuery);
            ResultSet rsl = stmt.executeQuery();
            while (rsl.next()){
                long id_utilisateur = rsl.getLong("id_utilisateur");
                String first_name = rsl.getString("first_name");
                String last_name = rsl.getString("last_name");
                String email = rsl.getString("email");
                String picture =  rsl.getString("picture");
                String telephone = rsl.getString("telephone");

                ProfileDTO utilisateur = new ProfileDTO(id_utilisateur, first_name, last_name, email, picture, telephone);
                listUtilisateur.add(utilisateur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUtilisateur;
    }


    @Override
    public ProfileDTO create(ProfileDTO dto) {

        var insertQuery = "INSERT INTO utilisateur (first_name, last_name, email, picture, telephone) VALUES (?, ? , ?, ?, ? )";

        try (var con =  DbAccess.getInstance().getCon();
            var pstmt = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, dto.getFirst_name());
            pstmt.setString(2, dto.getLast_name());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getPicture());
            pstmt.setString(5, dto.getTelephone());

            System.out.println("User create successfully");

            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0) {
                var rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    dto.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }



    @Override
    public ProfileDTO update(ProfileDTO dto) {
        return null;
    }

    @Override
    public boolean remove(ProfileDTO dto) {
        return false;
    }

    @Override
    public boolean removeById(Long aLong) {
        return false;
    }
}
