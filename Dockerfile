# ベースイメージ
FROM eclipse-temurin:21-jdk

# 作業ディレクトリを指定（実行ファイルを配布）
WORKDIR /app

# ローカルのjarファイルをコンテナにコピー
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# コンテナ起動時に実行するコマンド
ENTRYPOINT ["java", "-jar", "/app/app.jar"]