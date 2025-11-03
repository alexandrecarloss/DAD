import pandas as pd
from sqlalchemy import create_engine
from datetime import datetime

# ==============================
# 🔧 CONFIGURAÇÕES DO BANCO
# ==============================
MYSQL_USER = 'root'
MYSQL_PASSWORD = 'root'
MYSQL_HOST = 'localhost'
MYSQL_PORT = 3306
MYSQL_DB = 'dad_ibge'

# ==============================
# 📂 CAMINHOS DOS ARQUIVOS CSV
# ==============================
csv_estabelecimentos = r'C:\Users\user\Documents\Estabelecimentos.csv'
csv_profissionais = r'C:\Users\user\Documents\EstabelecimentoProfissionais.csv'
csv_ubs = r'C:\Users\user\Downloads\Unidades_Basicas_Saude-UBS_xml.csv'  # <== ajuste o caminho se necessário

# ==============================
# ⚙️ CONEXÃO COM MYSQL
# ==============================
engine = create_engine(
    f'mysql+pymysql://{MYSQL_USER}:{MYSQL_PASSWORD}@{MYSQL_HOST}:{MYSQL_PORT}/{MYSQL_DB}'
)

# # ==============================
# # 🏥 1. IMPORTAR ESTABELECIMENTOS
# # ==============================
# print("📥 Importando estabelecimentos...")
# df_est = pd.read_csv(csv_estabelecimentos, sep=';', encoding='utf-8', low_memory=False)

# # Remove colunas Unnamed
# df_est = df_est.loc[:, ~df_est.columns.str.contains('^Unnamed')]

# # Converte latitude/longitude para numérico
# for col in ['LATITUDE', 'LONGITUDE']:
#     if col in df_est.columns:
#         df_est[col] = pd.to_numeric(df_est[col], errors='coerce')

# # Insere dados no MySQL
# df_est.to_sql('estabelecimentos', con=engine, if_exists='append', index=False)
# print("✅ Dados de estabelecimentos importados com sucesso!")


# # ==============================
# # 👩‍⚕️ 2. IMPORTAR PROFISSIONAIS
# # ==============================
# print("📥 Importando profissionais...")
# df_prof = pd.read_csv(csv_profissionais, sep=',', encoding='utf-8', low_memory=False)

# # Remove colunas Unnamed
# df_prof = df_prof.loc[:, ~df_prof.columns.str.contains('^Unnamed')]

# # Renomeia colunas TO_CHAR(...)
# renomear_colunas = {
#     "TO_CHAR(DT_ATUALIZACAO,'DD/MM/YYYY')": "DT_ATUALIZACAO",
#     "TO_CHAR(DT_ATUALIZACAO_ORIGEM,'DD/MM/YYYY')": "DT_ATUALIZACAO_ORIGEM"
# }
# df_prof.rename(columns=renomear_colunas, inplace=True)

# # Converte colunas de data
# for col in ['DT_ENTRADA', 'DT_DESLIGAMENTO', 'DT_ATUALIZACAO', 'DT_ATUALIZACAO_ORIGEM']:
#     if col in df_prof.columns:
#         df_prof[col] = pd.to_datetime(df_prof[col], errors='coerce', dayfirst=True)

# # Insere dados no MySQL
# df_prof.to_sql('estabelecimentoprofissionais', con=engine, if_exists='append', index=False)
# print("✅ Dados de profissionais importados com sucesso!")


# ==============================
# 🗺️ 3. IMPORTAR UBS LOCALIZAÇÃO
# ==============================
print("📥 Importando Unidades Básicas de Saúde (UBS)...")

# Lê o CSV com separador vírgula
df_ubs = pd.read_csv(csv_ubs, sep=',', encoding='utf-8', low_memory=False)

# Remove colunas Unnamed
df_ubs = df_ubs.loc[:, ~df_ubs.columns.str.contains('^Unnamed')]

# Converte latitude/longitude
for col in ['LATITUDE', 'LONGITUDE']:
    if col in df_ubs.columns:
        df_ubs[col] = pd.to_numeric(df_ubs[col], errors='coerce')

# Remove linhas sem CNES ou UF
df_ubs = df_ubs.dropna(subset=['CNES', 'UF'])

# Garante tipos de colunas principais
df_ubs['CNES'] = df_ubs['CNES'].astype(str).str.zfill(7)
df_ubs['UF'] = df_ubs['UF'].astype(str)
df_ubs['IBGE'] = df_ubs['IBGE'].astype(str)

# Insere dados no MySQL
df_ubs.to_sql('ubs_localizacao', con=engine, if_exists='append', index=False)
print("✅ Dados de UBS importados com sucesso!")

print("\n🎉 Importação concluída com sucesso!")
