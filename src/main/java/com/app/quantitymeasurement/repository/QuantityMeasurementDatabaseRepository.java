package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = """
                INSERT INTO quantity_measurement_entity
                (operand1, operand2, measurement_type,
                 operation_type, result_value, error_flag, message)
                VALUES (?,?,?,?,?,?,?)
                """;

        Connection connection = null;

        try{

            connection = ConnectionPool.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, entity.getOperand1());
            ps.setString(2, entity.getOperand2());
            ps.setString(3, entity.getMeasurementType());
            ps.setString(4, entity.getOperationType());
            ps.setString(5, entity.getResultValue());
            ps.setBoolean(6, entity.isErrorFlag());
            ps.setString(7, entity.getMessage());

            ps.executeUpdate();

        }
        catch (Exception e){
            throw new DatabaseException("DB Save Failed", e);
        }
        finally {
            if(connection != null)
                ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM quantity_measurement_entity";

        Connection connection = null;

        try{

            connection = ConnectionPool.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                QuantityMeasurementEntity entity =
                        new QuantityMeasurementEntity(
                                rs.getString("operand1"),
                                rs.getString("operand2"),
                                rs.getString("measurement_type"),
                                rs.getString("operation_type"),
                                rs.getString("result_value"),
                                rs.getBoolean("error_flag"),
                                rs.getString("message")
                        );

                list.add(entity);
            }

        }
        catch (Exception e){
            throw new DatabaseException("DB Fetch Failed", e);
        }
        finally {
            if(connection != null)
                ConnectionPool.releaseConnection(connection);
        }

        return list;
    }
}