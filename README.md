# Jobme API based on an LLM

## Description

The jobme project in the [following repository](https://github.com/Momellouky/jobme) 
has some limitations. This repository tries to fix these limitations based on a Large Language Model (LLM).

One of the limitations we try to fix in this repository is the limited set of skillset 
the user could provide. For example, a user may want to provide a skill which is not present
in the skillset we provide. In this case, the user will not be able to get 
personalized recommendations. This limitation is mainly due to the limited training dataset 
we used to train our jobme model. 

An LLM is trained on a large set of data. In this project, we get benefit from
this feature to leverage a general model.