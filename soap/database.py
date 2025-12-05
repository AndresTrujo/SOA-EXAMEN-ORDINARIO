from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base

USUARIO = 'root'
PASSWORD = 'andetox1291' 
HOST = 'localhost'
PUERTO = '3306'
BASE_DATOS = 'db_matriculas'

DATABASE_URL = f"mysql+mysqlconnector://{USUARIO}:{PASSWORD}@{HOST}:{PUERTO}/{BASE_DATOS}"


engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

def get_bd():
    db = SessionLocal()
    try:
        return db
    finally:
        db.close()