const path = require("path");

module.exports = {
    development: {
        client: "mysql",
        connection: {
            host: "localhost",
            user: "root",
            password: "",
            port: 3306,
            database: "hackathon_3_periodo"
        },
        migrations: {
            directory: path.resolve(
                __dirname,
                "src",
                "database",
                "knex",
                "migrations"
            ),
        },
        useNullAsDefault: true,
    },
};
