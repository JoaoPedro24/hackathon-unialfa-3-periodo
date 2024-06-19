/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    return knex.schema.createTable("vacinas", (table) => {
        table.increments("id");
        table.string("nome", 255).notNullable();
        table.integer("prazo").nullable();
        table.integer("idade_minima").nullable();
        table.timestamp("created_at").defaultTo(knex.fn.now());
        table.timestamp("updated_at").defaultTo(knex.fn.now());
    });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    return knex.schema.dropTable("vacinas").then(() => {
        console.log("Deletado tabela de Vacinas");
    });
};
