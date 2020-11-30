# ML Landscape

## What is ML

Science of programming computers so they can learn from data

Data examples are called **training sets**. Each training example is called a **training instance**
Performance is measured in **accuracy**

ML is good in solving problems that either:

1. problems are too complex for traditonal approaches
2. have no known algoritme/can help find an algoritme
3. fluctuating environments: ML can learn machines to adapt to new data
4. can help humans learn to get insight in complex and large amount of data => data mining

|  | Description | Example |
| :---|    :----   | :---- |
| CNN | Convolutional Neural Netwerk | Image Classification 
|  |Segmantic Segmentation  | Brain scans |
| NLP | Natural Language Processing | News articles classification|
|  |  | Text Summary | 
| RNN | Recurring Neural Netwerk | News articles classification |
| NLU | Natural Language Understanding | Chatbot/personal assistant |
| SVM | Support Vector Machine | Forecasting |
| RL | Reinformcement Learning | |

**Regression model**:

- Linear
- Polynomial
- Random Forest
- when take past in account then RNN, CNN, Transformers

dimensionality reduction: Simplify the data without loosing too much information.
Feature extraction: merge one feature in an other and both will represent an new feature.

Anomaly detection: unusual credit card transactions to prevent fraud.
Novelty detection: detact new instances that look different from all training instances.

Association rule learning: dig in large datasets and discover interesting reations between attributes.

## Types of ML

1. **Supervised Learning**
    - Classification
    - K-Nearest Neighbours
    - Linear/Logistic regression (both predictor and their labels required)
    - SVM
    - Decision Tree
    - Random Forests
    - Neural Networks
2. **Unsupervised Learning**
    - Clustering
        - K-Means
        - DBSCAN
        - HCA (Hierarchical Cluster Analysis)
    - Anomaly detection and novelty detection
        - One-class SVM
        - Isolation Forest
    - Visualistation and dimensionality reduction
        - PCS (Principal Component Analysis)
        - Kernel PCA
        - LLE (Locally Linear Embedding)
        - t-SNE (t-Distributed Stochastic Neigbor Embedding)
    - Association rule learning
        - Apriori
        - Eclat
3. **Semi-supervised Learning**
    - partly labeled
    - mostly combination of supervised and unsupervised learning
    - DBN (Deep Believe Networks)
    - RBM (Resticted Boltzmann Machines)
4. **Reinforcement Learning**
    - Call an agent, observe the environment, select and perform actions, get reward or penalty. Learns by itself.

System can wheter or not learn increamentally from stream of incomming data

1. **Batch Learning**
    - must train with all data available (offline learning)
    - can take many hours to train and requires resources
    - when extreme much data, can be impossible to train or limited resources
    - new data then train system from scratch and (automatic) deploy
2. **Online learning**
    - train system incrementially, by feeding sequential data.
    - either individually or in mini-batches
    - great when data arrives in an continous flow
    - great approach when system needs to adapt quicky to new data.
    - requires less resources
    - when data does not fitt in memory => out-of-core learining
        then online learning perfect approach.
    - important parameter: learning rate
        - High then adapt quickly to chancing data, but forgets also quickly.
        - Low then learns slower, bet less sensitive to new data.
    - Problem when feed with bad data => performance will decline.
        Need to monitor system.

ML Systems how they generalize. Needs to prform well on new data!

1. **Instance-based learning**
    - learn examples by heart, then generalize to new cases by using similarity measures to compare.
2. **Model-based learning**
    - build model of examples and then use the model to make predictions
    - Use model selection to select an appropiate model and fully specifying its architecture.

Inference: make predictions on new data.


## Main challenges of ML

"Bad algorithme" and "bad data"

### Bad data

1. Insufficient quantity of training data
    - Not always easy and/or cheap to get extra training data
    - More data is better.
2. Nonrepresentative Training data
    - Crusial the data represents the case to generalize about.
        For both instant-based en model-based learning
    - If sample too small => sampling noise
    - If large sample but sampling method is flawed => sampling bias
        Sampling method: how data is collected
3. Poor-Quality data
    - Errors, outliers, noise => clean up data
    - Clearly outliers => discard them of try fix errors
    - missing few features => whether ignore attribute or fill in values manually
4. Irrelevant Features
    - Come up with a good set of features for training => feauture engineering:
        - feature selection (select most useful)
        - feature extraction (combine existing features to more useful one)
        - creating new features by gathering new data
5. Overfitting the training data
    Overfitting => model performs well on training dat, but does not generalize well.
    Overfitting happens when model is too complex relative to the amount and noisiness of the training data.
    Overfitting solutions:
        - simplify model by selecting model with fewer parameters, reducing number of attributes, constraining model.
            Constraining model => **regularization** result: will fit less the training data but generalises better to new data.
                Amount of reqularization is controlled by hyperparameters. A hyperparameter is a parameter of the learning algorithme (not of model)
        - gather more training data
        - reduce the noise in the training data (fix errors, remove outliers)
6. Underfitting the training data
    - Model is too simple to learn the structure of the data.
    - Solutions:
        - select more powerful model, with more parameters
        - improve feature engineering tasks
        - reduce contrains on the model (eg regularisation)
        


