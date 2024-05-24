// Importancia de expor os dados de forma abstrata

// Quanto maior o grau de generalidade a nivel conveniente do contexto for, melhor fica.
// Nao precisamos expor detalhes do que a tal variavel sera usada.
// Tais detalhes pode ser especificado no momento do seu uso.
// Contanto que a tal essencia abstrata esteja viva, e o suficiente e e o melhor a ser feito para adquirir o grau conveniente da abstracao

// Veiculo - Caso concreto - Muito especificado o que torna rigido a sua finalidade para o uso
public interface Vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}

// Veiculo - Caso Abstrato - Bom grau de abstracao o que torna flexivel para o seu uso.
public interface Vehicle {
    double getPercentFuelRemaining();
}
