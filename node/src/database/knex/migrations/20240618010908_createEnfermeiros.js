/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    return knex.schema
        .createTable("enfermeiros", (table) => {
            table.increments("id");
            table.string("nome", 255).notNullable();
            table.string("cpf", 255).notNullable();
            table.string("telefone", 255).notNullable();
            table.timestamp("created_at").defaultTo(knex.fn.now());
            table.timestamp("updated_at").defaultTo(knex.fn.now());
        })
        .then(() => {
            console.log("Criado tabela de Enfermeiros");
        });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    return knex.schema.dropTable("enfermeiros").then(() => {
        console.log("Deletado tabela de Enfermeiros");
    });
};
