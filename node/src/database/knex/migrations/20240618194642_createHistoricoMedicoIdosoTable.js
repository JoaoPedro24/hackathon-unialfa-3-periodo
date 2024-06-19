/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    return knex.schema
        .createTable("historicos_medicos_idosos", (table) => {
            table.increments("id");
            table.integer("id_idoso").unsigned()
            table.foreign("id_idoso").references("id").inTable("idosos");
            table.text("alergias").nullable();
            table.text("condicoes_preexistentes").nullable();
            table.text("observacoes").nullable();
            table.timestamp("created_at").defaultTo(knex.fn.now());
            table.timestamp("updated_at").defaultTo(knex.fn.now());
        })
        .then(() => {
            console.log("Criado tabela de Históricos médicos dos idosos");
        });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    return knex.schema.dropTable("historicos_medicos_idosos").then(() => {
        console.log("Deletado tabela de Históricos médicos dos idosos");
    });
};
