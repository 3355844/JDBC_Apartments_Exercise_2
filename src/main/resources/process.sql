CREATE PROCEDURE Test(IN x INT, IN  y INT, OUT res INT ) BEGIN
  SET res  = x + y;
END;