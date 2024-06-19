/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    return knex.schema
        .createTable("agendamentos", (table) => {
            table.increments("id");
            table.integer("id_idoso").unsigned()
            table.foreign("id_idoso").references("id").inTable("idosos");
            table.integer("id_enfermeiro").unsigned()
            table.foreign("id_enfermeiro").references("id").inTable("enfermeiros");
            table.integer("id_vacina").unsigned()
            table.foreign("id_vacina").references("id").inTable("vacinas");
            table.text("observacoes").nullable();
            table.timestamp("created_at").defaultTo(knex.fn.now());
            table.timestamp("updated_at").defaultTo(knex.fn.now());
        })
        .then(() => {
            console.log("Criado tabela de Agendamentos");
        });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    return knex.schema.dropTable("agendamentos").then(() => {
        console.log("Deletado tabela de Agendamentos");
    });
};
